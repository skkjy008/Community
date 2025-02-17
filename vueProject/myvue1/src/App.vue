<template>
  <div id="app">
    <router-view></router-view>
      </div>
</template>

<script>

export default {
  name: 'App',
  components: {
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
