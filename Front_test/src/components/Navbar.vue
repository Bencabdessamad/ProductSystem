<template>
    <div>
      <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
          <a class="navbar-brand"  href="/piece">
            <img  src="@/assets/logo.png" width="50" height="50" alt="">
          </a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="container">
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                  <RouterLink class="nav-link" to="/piece">
                    Produit
                    <svg xmlns="http://www.w3.org/2000/svg" fill="#ffffff" height="2em" viewBox="0 0 512 512">
                      <path d="M326.3 218.8c0 20.5-16.7 37.2-37.2 37.2h-70.3v-74.4h70.3c20.5 0 37.2 16.7 37.2 37.2zM504 256c0 137-111 248-248 248S8 393 8 256 119 8 256 8s248 111 248 248zm-128.1-37.2c0-47.9-38.9-86.8-86.8-86.8H169.2v248h49.6v-74.4h70.3c47.9 0 86.8-38.9 86.8-86.8z"/>
                    </svg>
                  </RouterLink>
                </li>                
                <li class="nav-item">
                  <RouterLink class="nav-link" to="/marque">Marque</RouterLink>
                </li>
                <li class="nav-item ml-2">
                  <RouterLink class="nav-link" to="/categorie">Categorie</RouterLink>
                </li>
              </ul>
              <ul class="navbar-nav d-flex align-items-center" >
                <li class="nav-item">
                  <RouterLink class="nav-link" to="/notification">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="#ffffff" height="2em" viewBox="0 0 448 512">
                      <path d="M224 0c-17.7 0-32 14.3-32 32V49.9C119.5 61.4 64 124.2 64 200v33.4c0 45.4-15.5 89.5-43.8 124.9L5.3 377c-5.8 7.2-6.9 17.1-2.9 25.4S14.8 416 24 416H424c9.2 0 17.6-5.3 21.6-13.6s2.9-18.2-2.9-25.4l-14.9-18.6C399.5 322.9 384 278.8 384 233.4V200c0-75.8-55.5-138.6-128-150.1V32c0-17.7-14.3-32-32-32zm0 96h8c57.4 0 104 46.6 104 104v33.4c0 47.9 13.9 94.6 39.7 134.6H72.3C98.1 328 112 281.3 112 233.4V200c0-57.4 46.6-104 104-104h8zm64 352H224 160c0 17 6.7 33.3 18.7 45.3s28.3 18.7 45.3 18.7s33.3-6.7 45.3-18.7s18.7-28.3 18.7-45.3z"/>
                    </svg>
                  </RouterLink>
                </li>                
                <li class="nav-item">
                  <RouterLink class="nav-link" to="/admin">
                    <svg xmlns="http://www.w3.org/2000/svg" fill="#ffffff" height="2em" viewBox="0 0 448 512">
                      <path d="M304 128a80 80 0 1 0 -160 0 80 80 0 1 0 160 0zM96 128a128 128 0 1 1 256 0A128 128 0 1 1 96 128zM49.3 464H398.7c-8.9-63.3-63.3-112-129-112H178.3c-65.7 0-120.1 48.7-129 112zM0 482.3C0 383.8 79.8 304 178.3 304h91.4C368.2 304 448 383.8 448 482.3c0 16.4-13.3 29.7-29.7 29.7H29.7C13.3 512 0 498.7 0 482.3z"/>
                    </svg>
                  </RouterLink>                
                </li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="footer">
        <button class="btn btn-danger" @click="logout">Déconnexion</button>
      </div>
    </div>
  </template>
  
  <script setup> 
  import { useRoute, useRouter } from 'vue-router';

const route = useRoute();
const router = useRouter();

const logout = () => {
      localStorage.removeItem('authToken');
      router.push('/');
};
  const App = {
    name: 'App',
  };
  </script>
  
  <style scoped>
  .footer {
    position: fixed;
    bottom: 0;
    left: 0;
    right: 0;
    background-color: #f0f0f0;
    padding: 10px;
    display: flex;
    justify-content: flex-end;
    z-index: 1; 
  }
  
  .footer button {
    margin: 0;
  }
  
  .navbar {
    background-color: #343a40;
  }
  
  .nav-link {
    color: #fff;
    font-weight: bold;
  }
  
  .nav-link:hover {
    color: #17a2b8;
  }
  
  .nav-item:not(:last-child) {
    margin-right: 10px;
  }
  
  .btn-danger {
    background-color: #dc3545;
    color: #fff;
    font-weight: bold;
    border: none;
  }
  
  .btn-danger:hover {
    background-color: #c82333;
  }
  </style>
  