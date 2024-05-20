<template>
    <div class="home-page">
      <h1>Bienvenue sur mon réseau social !</h1>
      <p>
        Connectez-vous avec vos amis et votre famille,
        partagez vos moments préférés et découvrez le monde qui vous entoure.
      </p>
    <login />
    </div>
  </template>
  
  <script>
import login from '../util/login.vue';

  export default {
    components: {
      login
    },
    methods: {
      login() {
        // Code pour se connecter
      },
      signup() {
        // Code pour s'inscrire
      }
    }
  }
  </script>
  
  <style scoped>

  </style>
  