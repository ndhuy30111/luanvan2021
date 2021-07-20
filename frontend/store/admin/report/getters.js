export default {
  getDataCategoryDoughnutChart: (state) => {
    return {
      labels: state.labelCategory,
      datasets: [
        {
          label: 'Dữ liệu đầu tiên',
          data: state.valueCategory,
          backgroundColor: state.colorCategory,
          borderColor: state.colorCategory,
          borderWidth: 1,
        },
      ],
    }
  },
  getSumDay: (state) => {
    return state.sumDay
  },
  getSumWeek: (state) => {
    return {
      labels: state.labelSumWeek,
      datasets: [
        {
          label: 'Dữ liệu đầu tiên',
          data: state.valueSumWeek,
          backgroundColor: state.colorSumWeek,
          borderColor: state.colorSumWeek,
          borderWidth: 1,
        },
      ],
    }
  },
}
