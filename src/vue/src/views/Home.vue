<template>
  <div>
    <ArticleList :articles="articles"></ArticleList>
  </div>
</template>

<script>
import ArticleList from "@/components/ArticleList.vue";
import ArticleService from "@/services/ArticleService.js";
export default {
  components: {
    ArticleList
  },
  data: () => ({
    articles: []
  }),
  async beforeMount() {
    this.articles = (await ArticleService.all()).data;
  }
};
</script>