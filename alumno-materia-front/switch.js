// switch.js

function switchToAlumnos() {
  document.getElementById("alumnos-tab").classList.add("active");
  document.getElementById("materias-tab").classList.remove("active");
  document.getElementById("alumnos").classList.add("show", "active");
  document.getElementById("materias").classList.remove("show", "active");
}

function switchToMaterias() {
  document.getElementById("materias-tab").classList.add("active");
  document.getElementById("alumnos-tab").classList.remove("active");
  document.getElementById("materias").classList.add("show", "active");
  document.getElementById("alumnos").classList.remove("show", "active");
}
