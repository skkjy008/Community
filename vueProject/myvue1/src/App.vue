<template>
  <div id="app">
    <h1 id="title">Vue.js 로그인 예제</h1>
      <div id="login">
    <LoginForm />
      </div>
  </div>
</template>

<script>
import LoginForm from './components/LoginForm.vue';

export default {
  name: 'App',
  components: {
    LoginForm,
  },
};
</script>

<style>
#app {
  font-family: Arial, sans-serif;
  text-align: center;
  margin-top: 50px;
  
}

#title{

  margin-right: 100px;

}

#login{
  font-family: Arial, sans-serif;
  text-align: center;
  max-width: 700px;
  margin-top: 70px;
  border: 2px solid rgba(0, 0, 0, 0.205);
  border-radius: 10px;

}
</style>
