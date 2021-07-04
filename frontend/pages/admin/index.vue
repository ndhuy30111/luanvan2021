<template>
  <v-container>
    <v-row>
      <v-col cols="12" sm="9">
        <v-container>
          <v-row>
            <v-col
              ><v-card color="red"
                ><v-card-title>
                  <span class="text">{{ notSize }}</span></v-card-title
                >
                <v-card-subtitle
                  ><span class="text"
                    >Đơn hàng chưa xử lý</span
                  ></v-card-subtitle
                >
              </v-card></v-col
            >
            <v-col
              ><v-card color="amber"
                ><v-card-title
                  ><span class="text">{{ accuracySize }}</span></v-card-title
                >
                <v-card-subtitle
                  ><span class="text"
                    >Đơn hàng cần vận chuyển</span
                  ></v-card-subtitle
                >
              </v-card></v-col
            >
            <v-col
              ><v-card color="lime"
                ><v-card-title
                  ><span class="text">{{ transportSize }}</span></v-card-title
                >
                <v-card-subtitle
                  ><span class="text"
                    >Đơn hàng đang vẫn chuyển</span
                  ></v-card-subtitle
                >
              </v-card></v-col
            >
            <v-col
              ><v-card color="green"
                ><v-card-title
                  ><span class="text">{{ completeSize }}</span></v-card-title
                >
                <v-card-subtitle
                  ><span class="text"
                    >Đơn hàng đã hoàn thành</span
                  ></v-card-subtitle
                >
              </v-card></v-col
            >
          </v-row>
        </v-container>
      </v-col>
      <v-col cols="12" sm="3">
        <v-sheet rounded="lg" min-height="268">
          <v-date-picker
            v-model="picker"
            header-color="orange"
            color="orange"
            locale="vi"
          ></v-date-picker>
        </v-sheet>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  layout: 'admin',
  data: () => ({
    picker: new Date(Date.now()).toISOString().substr(0, 10),
  }),
  computed: {
    ...mapGetters({
      // map `this.doneCount` to `this.$store.getters.doneTodosCount`
      notSize: 'admin/invoice/getNotSize',
      accuracySize: 'admin/invoice/getAccuracySize',
      transportSize: 'admin/invoice/getTransportSize',
      completeSize: 'admin/invoice/getCompleteSize',
    }),
  },
}
</script>

<style>
.text {
  color: white;
}
</style>
