<template>
  <div>
    <Article :article="article"></Article>
  </div>
</template>

<script>
import Article from "@/components/Article.vue";
import ArticleService from "@/services/ArticleService.js";
export default {
  components: {
    Article
  },
  data() {
    return {
      article: {}
    };
  },
  props: {
    articleId: null
  },
  async mounted() {
    this.article = (await ArticleService.findById(this.articleId)).data;
  }
};
</script>