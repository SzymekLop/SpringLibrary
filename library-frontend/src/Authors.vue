<template>
  <div id="app">
    <div id="page-header" class="content-box shadow-box">
      <h1 class="page-header-item">
        <a class="page-button" href="/">Library App</a>
      </h1>
      <a class="page-button button shadow-box" href="books">Książki</a>
      <a class="page-button button shadow-box" href="authors">Autorzy</a>
    </div>
    <div id="page-content" class="content-box shadow-box">
      <adding-author-form
        @update:author="updateAuthor"
        @add:author="addAuthor"
      ></adding-author-form>

      <authors-table
        :authorsSource="authors"
        @onDelete="deleteAuthor"
      ></authors-table>
    </div>
  </div>
</template>

<script>
import AddingAuthorForm from "./components/AddingAuthorForm.vue";
import AuthorsTable from "./components/AuthorsTable.vue";
import axios from "axios";

export default {
  name: "AuthorsView",
  components: {
    AddingAuthorForm,
    AuthorsTable,
  },
  data() {
    return {
      authors: [],
    };
  },
  methods: {
    addAuthor(author) {
      axios
        .put("http://localhost:8080/authors", {
          name: author.name,
          surname: author.surname,
        })
        .then(() => {
          this.getAuthors();
        })
        .catch((e) => alert(e));
    },

    updateAuthor(author) {
      axios
        .put(`http://localhost:8080/authors/${author.id}`, {
          id: author.id,
          name: author.name,
          surname: author.surname,
        })
        .then(() => {
          this.getAuthors();
        })
        .catch((e) => alert(e));
    },

    getAuthors() {
      axios
        .get("http://localhost:8080/authors")
        .then((data) => {
          this.authors = data.data;
        })
        .catch((e) => alert(e));
    },

    deleteAuthor(id) {
      axios
        .delete(`http://localhost:8080/authors/${id}`)
        .then(() => {
          this.getAuthors();
        })
        .catch((e) => alert(e));
    },
  },
  mounted() {
    this.getAuthors();
  },
};
</script>

<style>
</style>
