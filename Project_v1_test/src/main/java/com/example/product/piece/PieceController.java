package com.example.product.piece;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/pieces")
public class PieceController {
    private static Logger logger = LoggerFactory.getLogger(PieceController.class);
    @Autowired
    private PieceService pieceService;
    @Autowired
    private NotificationService notificationService;

    @GetMapping
    public List<Piece> getAllPieces() {
        logger.debug("getAllPieces()");
        return pieceService.getAllPieces();
    }

    @GetMapping("/{pieceId}")
    public Piece getPieceById(@PathVariable int pieceId) {
        logger.debug("getPieceById()");return pieceService.getPieceById(pieceId);
    }

    @PostMapping("/save")
    public Piece createPiece(@RequestBody Piece piece) {
        logger.debug("createPiece()");logger.debug(piece.toString());return pieceService.createPiece(piece);
    }

    @PutMapping("/update/{pieceId}")
    public Piece updatePiece(@PathVariable int pieceId, @RequestBody Piece piece) {
        piece.setPieceId(pieceId);
        logger.debug("updatePiece()");logger.debug(piece.toString());
        return pieceService.updatePiece(piece);
    }

    @DeleteMapping("/delete/{pieceId}")
    public void deletePiece(@PathVariable int pieceId) {
        logger.debug("deletePiece()");pieceService.deletePiece(pieceId);
    }

    @PostMapping("/decrementerPiece")
    public ResponseEntity<Piece> decrementerPiece(@RequestBody Map<String, Integer> params) {
        if (params.containsKey("pieceId") && params.containsKey("buy")) {
            Integer pieceId = params.get("pieceId");
            Integer buy = params.get("buy");
            if (pieceId != null && buy != null) {
                Piece p = pieceService.decrementerQuantite(pieceId, buy);
                logger.debug("decrementerPiece()");
                if (p != null) {
                    return ResponseEntity.ok(p);
                } else {
                    return ResponseEntity.notFound().build();
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/rechercherPiece")
    public List<Piece> rechercherPiecesParNom(@RequestParam String nom) {
        logger.debug("rechercherPiecesParNom()");
        return pieceService.rechercherPiecesParNom(nom);
    }
    @GetMapping("/notification")
    public String getNotificationMessage() {
        if (notificationService.getNotificationMessage() != null) {
            String message = notificationService.getNotificationMessage();
            notificationService.setNotificationMessage(null, 0);
            logger.debug("getNotificationMessage()");
            return message;
        } else {
            return null;
        }
    }
//    @GetMapping("/notification")
//    public String getNotificationMessage() {
//        logger.debug("getNotificationMessage()");
//        return notificationService.getNotificationMessage();
//    }
//    @GetMapping("/notification")
//    public SseEmitter getNotifications() {
//        logger.debug("getNotifications()");
//        return notificationService.getSseEmitter();
//    }

//    @GetMapping("/api/notification/{pieceId}/{buy}")
//    public ResponseEntity<String> getNotificationMessage(@PathVariable int pieceId, @PathVariable int buy) {
//        String notificationMessage = notificationService.getNotificationMessage(pieceId, buy);
//        return ResponseEntity.ok(notificationMessage);
//    }




//    public ResponseEntity<Piece> decrementerPiece(@RequestParam int pieceid , @RequestParam int buy){
//        Piece p = pieceService.decrementerQuantite(pieceid, buy);
//        if(p!=null) {
//            return ResponseEntity.ok(p);
//        }else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}
