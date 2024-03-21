// Función para cargar los alumnos en la tabla
function loadAlumnos() {
  $.ajax({
      type: 'GET',
      url: 'http://localhost:8001/api/alumnos',
      success: function(alumnos) {
          $('#alumnosTableBody').empty();
          alumnos.forEach(function(alumno) {
              $('#alumnosTableBody').append(`
                  <tr>
                      <td>${alumno.idAlumno}</td>
                      <td>${alumno.nombre}</td>
                      <td>${alumno.apellidos}</td>
                      <td>${alumno.edad}</td>
                      <td>${alumno.carrera}</td>
                      <td>${alumno.materia.nombre}</td>
                      <td>
                          <button class="btn btn-danger" onclick="deleteAlumno(${alumno.idAlumno})">Eliminar</button>
                          <button class="btn btn-primary" onclick="openUpdateAlumnoModal(${alumno.idAlumno})">Actualizar</button>
                      </td>
                  </tr>
              `);
          });
      },
      error: function(err) {
          console.error(err);
          alert('Error al cargar los alumnos');
      }
  });
}


// Función para abrir el modal de actualizar Alumno
function openUpdateAlumnoModal(id) {
  loadAlumnoForUpdate(id);
  $('#updateAlumnoModal').modal('show');
}

// Función para cargar los datos del Alumno a actualizar en el modal correspondiente
function loadAlumnoForUpdate(id) {
  $.ajax({
      type: 'GET',
      url: `http://localhost:8001/api/alumnos/${id}`,
      success: function(alumno) {
          $('#updateIdAlumno').val(alumno.idAlumno);
          $('#updateNombre').val(alumno.nombre);
          $('#updateApellidos').val(alumno.apellidos);
          $('#updateEdad').val(alumno.edad);
          $('#updateCarrera').val(alumno.carrera);
          $('#updateMateria').val(alumno.materia.idMateria); // Suponiendo que el ID de la materia está disponible en la entidad Alumno
      },
      error: function(err) {
          console.error(err);
          alert('Error al cargar el Alumno para actualizar');
      }
  });
}

// Función para agregar un Alumno
function addAlumno() {
  // Obtener datos del formulario de agregar Alumno
  const id = $('#addAlumnoId').val();
  const nombre = $('#addNombre').val();
  const apellidos = $('#addApellidos').val();
  const edad = $('#addEdad').val();
  const carrera = $('#addCarrera').val();
  const materiaId = $('#addMateria').val();

  // Construir objeto Alumno
  const alumno = {
      idAlumno: id,
      nombre: nombre,
      apellidos: apellidos,
      edad: edad,
      carrera: carrera,
      materia: { idMateria: materiaId } // Suponiendo que el ID de la materia está disponible en el formulario de agregar Alumno
  };

  // Realizar solicitud POST para agregar Alumno
  $.ajax({
      type: 'POST',
      url: 'http://localhost:8001/api/alumnos',
      contentType: 'application/json',
      data: JSON.stringify(alumno),
      success: function(response) {
          // Recargar la tabla de Alumnos después de agregar uno nuevo
          loadAlumnos();
          // Cerrar el modal de agregar Alumno
          $('#addAlumnoModal').modal('hide');
          // Limpiar los campos del formulario de agregar Alumno
          $('#addNombre').val('');
          $('#addApellidos').val('');
          $('#addEdad').val('');
          $('#addCarrera').val('');
          $('#addMateria').val('');
      },
      error: function(err) {
          console.error(err);
          alert('Error al agregar el Alumno');
      }
  });
}

// Función para actualizar un Alumno
function updateAlumno() {
  // Obtener datos del formulario de actualizar Alumno
  const id = $('#updateIdAlumno').val();
  const nombre = $('#updateNombre').val();
  const apellidos = $('#updateApellidos').val();
  const edad = $('#updateEdad').val();
  const carrera = $('#updateCarrera').val();
  const materiaId = $('#updateMateria').val();

  // Construir objeto Alumno
  const alumno = {
      idAlumno: id,
      nombre: nombre,
      apellidos: apellidos,
      edad: edad,
      carrera: carrera,
      materia: { idMateria: materiaId } // Suponiendo que el ID de la materia está disponible en el formulario de actualizar Alumno
  };

  // Realizar solicitud PUT para actualizar Alumno
  $.ajax({
      type: 'PUT',
      url: `http://localhost:8001/api/alumnos/${id}`,
      contentType: 'application/json',
      data: JSON.stringify(alumno),
      success: function(response) {
          // Recargar la tabla de Alumnos después de actualizar
          loadAlumnos();
          // Cerrar el modal de actualizar Alumno
          $('#updateAlumnoModal').modal('hide');
      },
      error: function(err) {
          console.error(err);
          alert('Error al actualizar el Alumno');
      }
  });
}

// Función para eliminar un Alumno
function deleteAlumno(id) {
  // Confirmar antes de eliminar
  if (confirm('¿Estás seguro de que quieres eliminar este Alumno?')) {
      // Realizar solicitud DELETE para eliminar Alumno
      $.ajax({
          type: 'DELETE',
          url: `http://localhost:8001/api/alumnos/${id}`,
          success: function(response) {
              // Recargar la tabla de Alumnos después de eliminar uno
              loadAlumnos();
          },
          error: function(err) {
              console.error(err);
              alert('Error al eliminar el Alumno');
          }
      });
  }
}

// Función para inicializar la página
$(document).ready(function() {
  // Cargar los alumnos al cargar la página
  loadAlumnos();
});
