<template>
  <div>
    <video-game-list
      :idClient="idClient"
    />
  </div>
</template>

<script>
import VideoGameList from './VideoGameList';
export default {
  name: 'HeaderVideoGame',
  components: {
    VideoGameList
  },
  props: {
    idClient: {
      type: Number,
      required: true
    }
  }
};
</script>

<style scoped>

</style>
