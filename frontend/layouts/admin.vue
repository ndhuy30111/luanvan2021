<template>
  <div>
    <Nav />
    <div class="container-fluid">
      <div class="row content">
        <div class="col-sm-3 sidenav hidden-xs">
          <h2>Logo</h2>
          <ul class="nav nav-pills nav-stacked">
            <li class="active"><a href="#section1">Dashboard</a></li>
            <li><a href="#section2">Age</a></li>
            <li><a href="#section3">Gender</a></li>
            <li><a href="#section3">Geo</a></li>
          </ul>
          <br />
        </div>
        <br />
        <div class="col-sm-9">
          <div class="well">
            <h4>Dashboard</h4>
            <p>Some text..</p>
          </div>
          <div class="row">
            <Nuxt />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Nav from '~/components/admin/header/av.vue'
export default {
  components: { Nav },
  middleware: 'authenticated',
}
</script>

<style scoped>
.row.content {
  height: 550px;
}

.sidenav {
  background-color: #f1f1f1;
  height: 100%;
}

@media screen and (max-width: 767px) {
  .row.content {
    height: auto;
  }
}
</style>
