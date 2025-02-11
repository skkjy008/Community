<template>
    <div>
      <h1>게시판</h1>
      <ul>
        <li v-for="board in boards" :key="board.id">
          <router-link :to="`/boards/${board.id}`">{{ board.title }}</router-link>
        </li>
      </ul>
      <router-link to="/create">게시글 작성</router-link>
    </div>
  </template>
  
  <script>
  import api from "../services/api";
  
  export default {
    data() {
      return {
        boards: [],
      };
    },
    async created() {
      const response = await api.get("/");
      this.boards = response.data;
    },
  };
  </script>
  