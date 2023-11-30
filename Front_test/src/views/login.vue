<template>
  <div class="container py-5 h-100">
    <div class="row d-flex align-items-center justify-content-center h-100">
      <div class="col-md-8 col-lg-7 col-xl-6">
        <img src="@/assets/logo.png" class="img-fluid" alt="Phone image">
      </div>
      <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
        <div class="login-container">
          <h2 class="login-title">Login</h2>
          <form @submit.prevent="login">
            <div class="form-outline mb-4">
              <input type="text" id="email" v-model="email" class="form-control form-control-lg" required>
              <label class="form-label" for="email">Email address</label>
            </div>
            <div class="form-outline mb-4">
              <input type="password" id="password" v-model="password" class="form-control form-control-lg" required>
              <label class="form-label" for="password">Password</label>
            </div>
            <button type="submit" class="btn btn-primary btn-lg btn-block">Login</button>
          </form>
          <div class="error-message" v-if="loginFailed">Email or password incorrect</div>
        </div>
      </div>
    </div>
  </div>
</template>
  
  <script>
  import axios from 'axios';
  
  export default {
    data() {
      return {
        email: '',
        password: '',
        loginFailed: false,
      };
    },
    methods: {
      async login() {
        try {
          const response = await axios.post('http://localhost:8081/api/admins/login', {
            email: this.email,
            password: this.password,
          });
  
          if (response.data === 'Login successful') {
            const authToken = response.headers['authorization'];
            localStorage.setItem('authToken', authToken);
            this.$router.push('/piece');
          } else {
            console.log('Échec de la connexion');
            this.loginFailed = true;
          }
        } catch (error) {
          console.error('Erreur lors de la connexion :', error);
          this.loginFailed = true;
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .login-title {
    font-size: 2em;
    color: #333; 
    margin-bottom: 20px;
  }
  
  .error-message {
    color: red;
    margin-top: 10px;
  }
  </style>
  