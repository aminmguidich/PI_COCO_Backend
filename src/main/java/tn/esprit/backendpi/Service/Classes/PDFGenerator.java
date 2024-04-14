package tn.esprit.backendpi.Service.Classes;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import tn.esprit.backendpi.Entities.Contract;
import tn.esprit.backendpi.Entities.House;
import tn.esprit.backendpi.Service.Interfaces.IContractService;
import tn.esprit.backendpi.Service.Interfaces.IHouseService;
import tn.esprit.backendpi.Service.Interfaces.IpdfHouse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PDFGenerator implements IpdfHouse {

    @Autowired
    private IContractService contractService;

    @Autowired
    private IHouseService houseService;

    public byte[] generatePdf(Long contractId, Long houseId) throws IOException {
        Contract contract = contractService.findContractById(contractId);
        House house = houseService.findHouseById(houseId);

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true)) {
                // Positionner le logo en haut à droite de la page
                // Charger le logo
           //     PDImageXObject logoImageRight = PDImageXObject.createFromFile("C:/xampp/htdocs/img/Capture d'écran 2024-03-24 194426.png", document);


// Obtenir la largeur de la page
                float pageWidth = page.getMediaBox().getWidth();

// Obtenir la hauteur de la page
                float pageHeight = page.getMediaBox().getHeight();

// Définir les coordonnées de positionnement du logo
                float logoX = pageWidth - 100; // Décalage de 100 unités vers la gauche par rapport à l'extrémité droite de la page
                float logoY = pageHeight - 50; // Décalage de 50 unités vers le bas par rapport à l'extrémité supérieure de la page

// Dessiner le logo sur la page
               // contentStream.drawImage(logoImageRight, logoX, logoY, 100, 50); // 100 est la largeur du logo, 50 est la hauteur du logo

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 16);
                float titleWidth = PDType1Font.HELVETICA_BOLD.getStringWidth("Contrat de Location") / 1000f * 16f;
                float titleX = (page.getMediaBox().getWidth() - titleWidth) / 2f;
                contentStream.newLineAtOffset(titleX, 780);
                contentStream.showText("Contrat de Location");
                contentStream.endText();

                // Calculer la hauteur du titre
                float titleHeight = 16f; // Taille de la police du titre
                float spaceAfterTitle = 30; // Espace vertical souhaité entre le titre et le reste du contenu
                float contentY = 780 - titleHeight - spaceAfterTitle; // Calculer la nouvelle position Y du premier élément de contenu après le titre

                contentStream.beginText(); // <-- Ajoutez ceci pour commencer un nouveau bloc de texte
                contentStream.newLine();
                contentStream.endText(); // <-- Ajoutez ceci pour terminer le bloc de texte
                contentStream.beginText(); // <-- Ajoutez ceci pour commencer un nouveau bloc de texte
                contentStream.newLine();
                contentStream.endText(); // <-- Ajoutez ceci pour terminer le bloc de texte


                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA_BOLD, 14);
                contentStream.newLineAtOffset(50, 740);
                contentStream.showText("Règles à respecter entre locataires et propriétaires :");
                contentStream.endText();

                contentStream.beginText(); // <-- Ajoutez ceci pour commencer un nouveau bloc de texte
                contentStream.newLine();
                contentStream.endText(); // <-- Ajoutez ceci pour terminer le bloc de texte
                contentStream.beginText(); // <-- Ajoutez ceci pour commencer un nouveau bloc de texte
                contentStream.newLine();
                contentStream.endText(); // <-- Ajoutez ceci pour terminer le bloc de texte


                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 10);
                contentStream.newLineAtOffset(50, 720);
                contentStream.showText("1) Contrat de location : Les deux parties doivent respecter les termes du contrat de location");
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 10);
                contentStream.newLineAtOffset(50, 700);
                contentStream.showText("2) Entretien et réparations : Le propriétaire est responsable des réparations majeures, tandis que le locataire doit maintenir ");
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 10);
                contentStream.newLineAtOffset(50, 680);
                contentStream.showText("la propriété en bon état");
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 10);
                contentStream.newLineAtOffset(50, 660);
                contentStream.showText("3) Respect de la propriété : Le locataire doit respecter la propriété du propriétaire et éviter tout dommage délibéré ");
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 10);
                contentStream.newLineAtOffset(50, 640);
                contentStream.showText("ou négligence");
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 10);
                contentStream.newLineAtOffset(50, 620);
                contentStream.showText("4) Le propriétaire doit respecter la vie privée du locataire et ne peut accéder à la propriété qu'après avoir donné un préavis .");
                contentStream.endText();

                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 10);
                contentStream.newLineAtOffset(50, 600);
                contentStream.showText("raisonnable, sauf en cas d'urgence");
                contentStream.endText();
                ClassPathResource resource = new ClassPathResource("images/" + house.getImage());
                String imagePath = resource.getFile().getPath();
                // Image de la maison
           PDImageXObject houseImage = PDImageXObject.createFromFile(imagePath, document);
                float imageWidth = 200;
                float imageHeight = 75;
                float imageX = (page.getMediaBox().getWidth() - imageWidth) / 2f;
                float imageY = 500;
                contentStream.drawImage(houseImage, imageX, imageY, imageWidth, imageHeight);

                // Tableau
                String[] headers = {"Contrat ID", "House ID", "Description du contrat", "Nombre de places", "Type de maison"};
                String[] values = {
                        contract.getIdContract().toString(),
                        house.getIdHouse().toString(),
                        contract.getDescription(),
                        house.getPlaces().toString(),
                        house.getHouseType().toString()
                };

                drawTable(contentStream, 400, 500, headers, values, page.getMediaBox().getWidth());

                // Images de signature
               PDImageXObject signatureImageLeft = PDImageXObject.createFromFile("C:\\xampp\\htdocs\\img\\téléchargement.png", document);
                PDImageXObject signatureImageRight = PDImageXObject.createFromFile("C:\\xampp\\htdocs\\img\\télécharg.png", document);
               contentStream.drawImage(signatureImageLeft, 50, 50, 100, 50);
               contentStream.drawImage(signatureImageRight, page.getMediaBox().getWidth() - 150, 50, 100, 50);
            }

            try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
                document.save(byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray
                        ();
            }
        }
    }

    private static void drawTable(PDPageContentStream contentStream, float yStart, float tableWidth, String[] headers, String[] values, float pageWidth) throws IOException {
        float margin = 50;
        float yPosition = yStart;

        float rowHeight = 25f; // Réduire légèrement la hauteur des lignes
        float tableHeight = rowHeight * 2; // Deux lignes : une pour les titres et une pour les valeurs

        float[] columnWidths = {tableWidth * 0.2f, tableWidth * 0.2f, tableWidth * 0.2f, tableWidth * 0.2f, tableWidth * 0.2f}; // Taille des colonnes ajustée

        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 10); // Réduire la taille de la police des titres

        // Dessiner les titres dans la première ligne
        float textY = yPosition - 10; // Réduire l'écart entre les titres et les cellules
        float textX = margin;
        for (int i = 0; i < headers.length; i++) {
            drawCell(contentStream, textX, textY, columnWidths[i], rowHeight, headers[i], 10f); // Utiliser une taille de police plus petite pour les titres
            textX += columnWidths[i];
        }

        // Dessiner les valeurs dans la deuxième ligne
        textY -= rowHeight; // Déplacer vers le bas pour la deuxième ligne
        textX = margin;
        for (int i = 0; i < values.length; i++) {
            if (i < 2) { // Si c'est une case ID, utiliser une taille de police plus petite
                drawCell(contentStream, textX, textY, columnWidths[i], rowHeight, values[i], 8f); // Utiliser une taille de police encore plus petite pour les ID
            } else {
                drawCell(contentStream, textX, textY, columnWidths[i], rowHeight, values[i], 10f); // Utiliser la même taille de police pour les autres cellules
            }
            textX += columnWidths[i];
        }
    }


    private static void drawCell(PDPageContentStream contentStream, float x, float y, float width, float height, String text, float fontSize) throws IOException {
        contentStream.setLineWidth(1f);
        contentStream.setNonStrokingColor(0, 0, 0); // Couleur du texte
        contentStream.addRect(x, y, width, height);
        contentStream.stroke();
        contentStream.beginText();

        float lineHeight = height - 2 * 2f;

        float textWidth = PDType1Font.HELVETICA.getStringWidth(text) / 1000f * fontSize;
        float textHeight = lineHeight; // Margin haut et bas

        // Centrer le texte horizontalement et verticalement dans la cellule
        float offsetX = (width - textWidth) / 2;
        float offsetY = (textHeight - fontSize) / 2;
        contentStream.newLineAtOffset(x + offsetX, y + offsetY);
        contentStream.setFont(PDType1Font.HELVETICA, fontSize);
        contentStream.showText(text);
        contentStream.endText();
    }

}

