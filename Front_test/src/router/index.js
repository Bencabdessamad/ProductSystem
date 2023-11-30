import { createRouter, createWebHistory } from 'vue-router';
import produit from '../views/produits/produit.vue';
import marque from '../views/marques/marque.vue';
import categorie from '../views/categories/categorie.vue';
import admin from '../views/admins/admin.vue';
import pieceCreate from '../views/produits/pieceCreate.vue';
import marqueCreate from '../views/marques/marqueCreate.vue';
import categorieCreate from '../views/categories/categorieCreate.vue';
import updateCategorie from '../views/categories/updateCategorie.vue';
import updateMarque from '../views/marques/updateMarque.vue';
import updatePiece from '../views/produits/updatePiece.vue';
import login from "@/views/login.vue";
import notification from '@/views/produits/notification.vue';

const router = createRouter({
    history: createWebHistory(
        import.meta.env.BASE_URL),
    routes: [{
            path: '/',
            name: 'login',
            component: login,
            meta: {
                hideNavbar: true,
                hideFooter: true
            }
        },
        {
            path: '/piece',
            name: 'pieces',
            component: produit
        },
        {
            path: '/piece/create',
            name: 'pieceCreate',
            component: pieceCreate
        },
        {
            path: '/marque',
            name: 'marque',
            component: marque
        },
        {
            path: '/marque/create',
            name: 'marqueCreate',
            component: marqueCreate
        },
        {
            path: '/categorie',
            name: 'categorie',
            component: categorie
        },
        {
            path: '/categorie/create',
            name: 'categorieCreate',
            component: categorieCreate
        },
        {
            path: '/admin',
            name: 'admin',
            component: admin
        },
        {
            path: '/categories/:id',
            name: 'updateCategorie',
            component: updateCategorie
        },
        {
            path: '/marques/:id',
            name: 'updateMarque',
            component: updateMarque
        },
        {
            path: '/pieces/:id',
            name: 'updatePiece',
            component: updatePiece
        },
        {
            path: '/notification',
            name: 'notification',
            component: notification
        }
    ]
});

export default router;