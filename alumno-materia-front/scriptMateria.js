// URL del backend
const BASE_URL = 'http://localhost:8001/api/materias';

// Función para abrir el modal de agregar Materia
function openModal(modalId) {
    $('#' + modalId).modal('show');
}

// Función para abrir el modal de agregar Materia
function closeModal(modalId) {
  $('#' + modalId).modal('hide');
}

// Función para abrir el modal de actualización con los datos de la materia seleccionada
function openUpdateModal(id) {
  loadMateriaForUpdate(id);
  $('#updateMateriaModal').modal('show');
}

// Función para agregar una nueva Materia
function addMateria() {
  const id = parseInt($('#id').val());
  const nombre = $('#nombre').val();
  const nivel = parseInt($('#nivel').val());
  const creditos = parseInt($('#creditos').val());
  const docente = parseInt($('#docente').val());

  const materia = {
      idMateria: id,
      nombre: nombre,
      nivel: nivel,
      creditos: creditos,
      docente: docente
  };

  $.ajax({
      type: 'POST',
      url: BASE_URL,
      contentType: 'application/json',
      data: JSON.stringify(materia),
      success: function(response) {
          console.log(response);
          closeModal('addMateriaModal')
          // $('#addMateriaModal').modal('hide');
          loadMaterias();
      },
      error: function(err) {
          console.error(err);
          alert('Error al agregar la Materia');
      }
  });
}

// Función para cargar todas las Materias en la tabla
function loadMaterias() {
  $.ajax({
      type: 'GET',
      url: BASE_URL,
      success: function(materias) {
          $('#materiasTableBody').empty();
          materias.forEach(function(materia) {
              $('#materiasTableBody').append(`
                  <tr>
                      <td>${materia.idMateria}</td>
                      <td>${materia.nombre}</td>
                      <td>${materia.nivel}</td>
                      <td>${materia.creditos}</td>
                      <td>${materia.docente}</td>
                      <td>
                          <button class="btn btn-danger" onclick="deleteMateria(${materia.idMateria})">Eliminar</button>
                          <button class="btn btn-primary" onclick="openUpdateModal(${materia.idMateria})">Actualizar</button>
                      </td>
                  </tr>
              `);
          });
      },
      error: function(err) {
          console.error(err);
          alert('Error al cargar las materias');
      }
  });
}

// Función para eliminar una Materia
function deleteMateria(idMateria) {
    if (confirm('¿Estás seguro de que quieres eliminar esta Materia?')) {
        $.ajax({
            type: 'DELETE',
            url: `${BASE_URL}/${idMateria}`,
            success: function(response) {
                console.log(response);
                loadMaterias();
            },
            error: function(err) {
                console.error(err);
                alert('Error al eliminar la Materia, este fue el id= ' + idMateria);
            }
        });
    }
}

// Función para cargar los datos de una materia en el modal de actualización
function loadMateriaForUpdate(id) {
  // Realizar una solicitud GET al backend para obtener los datos de la materia con el ID proporcionado
  $.ajax({
      type: 'GET',
      url: BASE_URL + '/' + id,
      success: function(materia) {
          // Llenar el formulario de actualización con los datos de la materia
          $('#updateId').val(materia.idMateria);
          $('#updateMateriaNombre').val(materia.nombre);
          $('#updateNivel').val(materia.nivel);
          $('#updateCreditos').val(materia.creditos);
          $('#updateDocente').val(materia.docente);

          // Mostrar el modal de actualización
          $('#updateMateriaModal').modal('show');
      },
      error: function(err) {
          console.error(err);
          alert('Error al cargar la materia para actualizar');
      }
  });
}

// Función para enviar los datos actualizados de la materia al backend
function updateMateria() {
  const id = parseInt($('#updateId').val());
  const nombre = $('#updateMateriaNombre').val();
  const nivel = parseInt($('#updateNivel').val());
  const creditos = parseInt($('#updateCreditos').val());
  const docente = parseInt($('#updateDocente').val());

  const materia = {
      idMateria: id,
      nombre: nombre,
      nivel: nivel,
      creditos: creditos,
      docente: docente
  };

  $.ajax({
      type: 'PUT',
      url: BASE_URL + '/' + id,
      contentType: 'application/json',
      data: JSON.stringify(materia),
      success: function(response) {
          console.log(response);
          $('#updateMateriaModal').modal('hide');
          loadMaterias();
      },
      error: function(err) {
          console.error(err);
          alert('Error al actualizar la materia');
      }
  });
}

// Función para cargar todas las Materias al cargar la página
$(document).ready(function() {
  loadMaterias();
});
