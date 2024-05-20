
<template>
    <div class="login-box">
      <h2>Login</h2>
      <form @submit.prevent="login">
        <div class="user-box">
            <label for="email">Adresse e-mail</label>
            <input type="email" id="email" v-model="email" required>
        </div>
        <div class="user-box">
            <label for="password">Mot de passe</label>
            <input type="password" id="password" v-model="password" required>
        </div>
        <div class="user-box">
            <button type="submit" @click="login">Se connecter</button>
        </div>
      </form>
    </div>
    </template>
    
<script>
import { ref, inject } from 'vue'
import axios from 'axios'

export default {
  setup() {
    const email = ref('')
    const password = ref('')
    

    const login = () => {
        console.log(email.value, password.value)
      const url = 'http://localhost:8090/api/v1/user/Login'
      const data = {
        email: email.value,
        password: password.value
      }
      axios.post(url, data)
        .then(response => {
          // Gérer la réponse de l'API
          console.log(response.data)
          // Enregistrer le jeton d'authentification dans le stockage local
          localStorage.setItem('token', response.data.token)
          // Rediriger vers la page d'accueil
        
        })
        .catch(error => {
          // Gérer les erreurs de l'API
          console.error(error)
        })
    }

    return {
      email,
      password,
      login,
    }
  }
}
</script>
    
    <style scoped>
    html {
      height: 100%;
    }
    
    .login-box {
      position: absolute;
      top: 50%;
      left: 50%;
      width: 400px;
      padding: 40px;
      transform: translate(-50%, -50%);
      background: rgba(0,0,0,.5);
      box-sizing: border-box;
      box-shadow: 0 15px 25px rgba(0,0,0,.6);
      border-radius: 10px;
    }
    
    .login-box h2 {
      margin: 0 0 30px;
      padding: 0;
      color: #fff;
      text-align: center;
    }
    
    .login-box .user-box {
      position: relative;
    }
    
    .login-box .user-box input {
      width: 100%;
      padding: 10px 0;
      font-size: 16px;
      color: #fff;
      margin-bottom: 30px;
      border: none;
      border-bottom: 1px solid #fff;
      outline: none;
      background: transparent;
    }
    .login-box .user-box label {
      position: absolute;
      top:0;
      left: 0;
      padding: 10px 0;
      font-size: 16px;
      color: #fff;
      pointer-events: none;
      transition: .5s;
    }
    
    .login-box .user-box input:focus ~ label,
    .login-box .user-box input:valid ~ label {
      top: -20px;
      left: 0;
      color: #03e9f4;
      font-size: 12px;
    }
    
    .login-box form a {
      position: relative;
      display: inline-block;
      padding: 10px 20px;
      color: #03e9f4;
      font-size: 16px;
      text-decoration: none;
      text-transform: uppercase;
      overflow: hidden;
      transition: .5s;
      margin-top: 40px;
      letter-spacing: 4px
    }
    </style>