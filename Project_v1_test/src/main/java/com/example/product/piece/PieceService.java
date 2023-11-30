package com.example.product.piece;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class PieceService {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private PieceRepository pieceRepository;
    public List<Piece> getAllPieces() {
        return pieceRepository.findAll();
    }

    public Piece getPieceById(int pieceId) {
        return pieceRepository.findById(pieceId).orElse(null);
    }

    public Piece createPiece(Piece piece) {
        return pieceRepository.save(piece);
    }

    public Piece updatePiece(Piece piece) {
        return pieceRepository.save(piece);
    }

    public void deletePiece(int pieceId) {
        pieceRepository.deleteById(pieceId);
    }


//    public Piece decrementerQuantite(int pieceId, int buy) {
//        Optional<Piece> op = pieceRepository.findById(pieceId);
//        if (op.isPresent()) {
//            Piece piece = op.get();
//            int quantiteAvant = piece.getQuantite();
//            if (quantiteAvant - buy < 0) {
//                piece.setQuantite(0);
//                piece = pieceRepository.save(piece);
//                String notificationMessage = "Le stock de la pièce " + piece.getNom() + " est maintenant vide.";
//                notificationService.envoyerNotification(notificationMessage);
//            } else {
//                int nouvelleQuantite = quantiteAvant - buy;
//                piece.setQuantite(nouvelleQuantite);
//                piece = pieceRepository.save(piece);
//                String notificationMessage;
//                if (nouvelleQuantite == 0) {
//                    notificationMessage = "Le stock de la pièce " + piece.getNom() + " est maintenant vide.";
//                } else if (nouvelleQuantite == 10) {
//                    notificationMessage = "La quantité de la pièce " + piece.getNom() + " est maintenant de 10.";
//                } else if (nouvelleQuantite < 10) {
//                    notificationMessage = "La quantité de la pièce " + piece.getNom() + " est inférieure à 10.";
//                } else {
//                    notificationMessage = "La quantité de la pièce " + piece.getNom() + " est maintenant de " + nouvelleQuantite + ".";
//                }
//                notificationService.envoyerNotification(notificationMessage);
//            }
//            return piece;
//        } else {
//            return null;
//        }
//    }

//            public Piece decrementerQuantite(int pieceId, int buy) {
//                Optional<Piece> op = pieceRepository.findById(pieceId);
//                if (op.isPresent()) {
//                    Piece piece = op.get();
//                    int quantiteAvant = piece.getQuantite();
//                    if (quantiteAvant - buy < 0) {
//                        piece.setQuantite(0);
//                        piece = pieceRepository.save(piece);
//                    } else {
//                        int nouvelleQuantite = quantiteAvant - buy;
//                        piece.setQuantite(nouvelleQuantite);
//                        piece = pieceRepository.save(piece);
//                        String notificationMessage;
//                        if (nouvelleQuantite == 0) {
//                            notificationService.setNotificationMessage("Le stock de la pièce " + piece.getNom() + " est maintenant vide.");
//                        } else if (nouvelleQuantite == 10) {
//                            notificationService.setNotificationMessage("La quantité de la pièce " + piece.getNom() + " est maintenant de 10.");
//                        } else if (nouvelleQuantite < 10) {
//                            notificationService.setNotificationMessage("La quantité de la pièce " + piece.getNom() + " est inférieure à 10.");
//                        } else {
//                            notificationService.setNotificationMessage("La quantité de la pièce " + piece.getNom() + " est maintenant de " + nouvelleQuantite + ".");
//                        }
//                    }
//                    return piece;
//                } else {
//                    return null;
//                }
//            }


//public Piece decrementerQuantite(int pieceId, int buy) {
//    Optional<Piece> op = pieceRepository.findById(pieceId);
//    if (op.isPresent()) {
//        Piece piece = op.get();
//        int quantiteAvant = piece.getQuantite();
//        if (quantiteAvant - buy < 0) {
//            piece.setQuantite(0);
//            piece = pieceRepository.save(piece);
//        } else {
//            int nouvelleQuantite = quantiteAvant - buy;
//            piece.setQuantite(nouvelleQuantite);
//            piece = pieceRepository.save(piece);
//
//            if (nouvelleQuantite == 0) {
//                notificationService.setNotificationMessage(
//                        "Le stock de la pièce " + piece.getNom() + " est maintenant vide.",
//                        1000
//                );
//            } else if (nouvelleQuantite == 10) {
//                notificationService.setNotificationMessage(
//                        "La quantité de la pièce " + piece.getNom() + " est maintenant de 10.",
//                        1000
//                );
//            } else if (nouvelleQuantite < 10) {
//                notificationService.setNotificationMessage(
//                        "La quantité de la pièce " + piece.getNom() + " est inférieure à 10.",
//                        1000
//                );
//            } else {
//                notificationService.setNotificationMessage(
//                        "La quantité de la pièce " + piece.getNom() + " est maintenant de " + nouvelleQuantite + ".",
//                        1000
//                );
//            }
//        }
//        return piece;
//    } else {
//        return null;
//    }
//}
public Piece decrementerQuantite(int pieceId, int buy) {
    Optional<Piece> op = pieceRepository.findById(pieceId);
    if (op.isPresent()) {
        Piece piece = op.get();
        int quantiteAvant = piece.getQuantite();
        if (quantiteAvant - buy < 0) {
            notificationService.setNotificationMessage(
                    "La quantité demandée pour la pièce " + piece.getNom() + " n'est pas disponible.",
                    1000
            );
        } else {
            int nouvelleQuantite = quantiteAvant - buy;
            piece.setQuantite(nouvelleQuantite);
            piece = pieceRepository.save(piece);

            if (nouvelleQuantite == 0) {
                notificationService.setNotificationMessage(
                        "Le stock de la pièce " + piece.getNom() + " est maintenant vide.",
                        1000
                );
            } else if (nouvelleQuantite == 10) {
                notificationService.setNotificationMessage(
                        "La quantité de la pièce " + piece.getNom() + " est maintenant de 10.",
                        1000
                );
            } else if (nouvelleQuantite < 10) {
                notificationService.setNotificationMessage(
                        "La quantité de la pièce " + piece.getNom() + " est inférieure à 10.",
                        1000
                );
            } else {
                notificationService.setNotificationMessage(
                        "La quantité de la pièce " + piece.getNom() + " est maintenant de " + nouvelleQuantite + ".",
                        1000
                );
            }
        }
        return piece;
    } else {
        return null;
    }
}

    public List<Piece> rechercherPiecesParNom(String nom) {
        return pieceRepository.findByNom(nom);
    }
}
//    public Piece decrementerQuantite(int pieceId, int buy) {
//        Optional<Piece> op = pieceRepository.findById(pieceId);
//        if(op.isPresent()) {
//            Piece piece = op.get();
//            piece.setQuantite(piece.getQuantite()-buy);
//            return pieceRepository.save(piece);
//        }else {
//            return null;
//        }
//    }