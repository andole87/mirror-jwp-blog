<template>
  <div>
    <v-row align="center" justify="center" id="title">
      <v-col sm="8" md="8">
        <v-text-field prepend-icon="title" solo @focus.once="clearTitle" v-model="title"></v-text-field>
      </v-col>
    </v-row>
    <v-row align="center" justify="center">
      <v-col sm="8" md="8">
        <Editor v-model="editorText" @focus.once="clearEditor" height="500px" />
      </v-col>
    </v-row>
    <v-row justify="center">
      <v-col sm="1" md="1">
        <v-btn @click="publish" color="pink lighten-2" dark block>Publish</v-btn>
      </v-col>
    </v-row>
  </div>
</template>
<script>
import "tui-editor/dist/tui-editor.css";
import "tui-editor/dist/tui-editor-contents.css";
import "codemirror/lib/codemirror.css";
import Editor from "@toast-ui/vue-editor/src/Editor.vue";
import ArticleService from "@/services/ArticleService.js";
export default {
  components: {
    Editor
  },
  data() {
    return {
      title: "제목을 입력하세요",
      editorText: "본문을 입력하세요"
    };
  },
  methods: {
    clearTitle() {
      this.title = "";
    },
    clearEditor() {
      this.editorText = "";
    },
    async publish() {
      const params = {
        email: "email@email.com",
        title: this.title,
        contents: this.editorText
      };
      const createUrl = (await ArticleService.publish(params)).headers.location;
      const articleId = this.getArticleId(createUrl);
      this.$router.replace({
        name: "article",
        params: {
          articleId
        }
      });
    },
    getArticleId(absoluteUrl) {
      return absoluteUrl.substr(absoluteUrl.lastIndexOf("/") + 1);
    }
  }
};
</script>

<style  scoped>
#title {
  height: 60px;
}
</style>