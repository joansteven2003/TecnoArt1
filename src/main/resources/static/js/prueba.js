let dataTable;
let dataTableIsInitialized = false;

let dataTableOptions = {
  dom: 'Bfrtilp',
  buttons: [
    {
      autoWidth: true,
      extend: 'excelHtml5',
      text: '<i class="fas fa-file-excel"></i> ',
      titleAttr: 'Exportar a Excel',
      className: 'btn btn-success',
    },
    {
      extend: 'pdfHtml5',
      text: '<i class="fas fa-file-pdf"></i> ',
      titleAttr: 'Exportar a PDF',
      className: 'btn btn-danger',
    },
    {
      extend: 'print',
      text: '<i class="fa fa-print"></i> ',
      titleAttr: 'Imprimir',
      className: 'btn btn-info',
    },
  ],
  lengthMenu: [5, 10, 15, 20, 100, 200, 500],
  
  
};

const initDataTable = async () => {
  if (dataTableIsInitialized) {
    dataTable.destroy();
  }



  dataTable = $('#example').DataTable(dataTableOptions);

  dataTableIsInitialized = true;
};

window.addEventListener('load', async () => {
  await initDataTable();
});