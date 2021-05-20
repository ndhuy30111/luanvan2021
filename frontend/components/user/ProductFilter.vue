<template>
  <v-row class="ProductFilter">
    <b-button v-b-toggle.sidebar-1 variant="light">
      <b-icon icon="filter"></b-icon>
    </b-button>
    <b-sidebar
      id="sidebar-1"
      title="Filter"
      shadow
      backdrop
      backdrop-variant="dark"
    >
      <hr />
      <div class="px-3 py-2">
        <h5>Danh mục</h5>
        <hr />
        <v-treeview :items="items"></v-treeview>
      </div>
      <hr />
      <div class="px-3 py-2">
        <h5>Giá</h5>
        <hr />
        <v-row>
          <v-col cols="12" sm="12" md="12">
            <v-radio-group column>
              <v-radio label="0 - 1000000" value="1"></v-radio>
              <v-radio label="1000000 - 200000" value="2"></v-radio>
              <v-radio label="2000000- 300000" value="3"></v-radio>
              <v-radio label=">3000000" value="4"></v-radio>
            </v-radio-group>
          </v-col>
        </v-row>
      </div>
      <hr />
      <div class="px-3 py-2">
        <h5>Size</h5>
        <hr />
        <v-row>
          <v-col cols="12" sm="6" md="6">
            <v-radio-group v-model="size" column>
              <v-radio label="S" value="S"></v-radio>
              <v-radio label="M" value="M"></v-radio>
              <v-radio label="L" value="L"></v-radio>
              <v-radio label="XL" value="XL"></v-radio>
            </v-radio-group>
          </v-col>
        </v-row>
      </div>
      <hr />
      <div class="px-3 py-2">
        <h5>Màu</h5>
        <hr />
        <v-row>
          <v-col cols="12" sm="6" md="6">
            <v-radio-group v-model="color" column>
              <v-radio label="Xanh dương" color="blue" value="blue"></v-radio>
              <v-radio label="Xanh lá" color="green" value="green"></v-radio>
            </v-radio-group>
          </v-col>
          <v-col cols="12" sm="6" md="6">
            <v-radio-group column>
              <v-radio label="Đỏ" color="red" value="red"></v-radio>
              <v-radio label="Đen" color="black" value="black"></v-radio>
            </v-radio-group>
          </v-col>
        </v-row>
      </div>
    </b-sidebar>
  </v-row>
</template>

<script>
export default {
  data: () => ({
    color: '',
    size: '',
    items: [
      {
        id: 1,
        name: 'Men',
        children: [
          { id: 2, name: 'Áo thun' },
          { id: 3, name: 'Áo sơ mi' },
          { id: 4, name: 'Thể thao' },
        ],
      },
      {
        id: 5,
        name: 'Women',
        children: [
          {
            id: 6,
            name: 'Áo',
            children: [
              { id: 7, name: 'Áo sơ mi' },
              { id: 8, name: 'Áo cổ lọ' },
              { id: 8, name: 'Áo thun' },
            ],
          },
          {
            id: 10,
            name: 'Váy',
            children: [
              { id: 7, name: 'Váy jean' },
              { id: 8, name: 'Váy dài' },
              { id: 8, name: 'Váy ngắn' },
            ],
          },
        ],
      },
    ],
  }),
}
</script>

<style lang="scss" scoped>
.ProductFilter {
  margin: 10px 0px -60px 0px;
  .btn-light {
    z-index: 13;
  }
  h6 {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  }
}
</style>
