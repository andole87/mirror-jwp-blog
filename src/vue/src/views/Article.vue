<template>
  <div>
    <Article :article="article"></Article>
  </div>
</template>

<script>
import Article from "@/components/Article.vue";
export default {
  components: {
    Article
  },
  props: {
    article: {
      type: Object,
      required: true
    }
  }
};
</script>