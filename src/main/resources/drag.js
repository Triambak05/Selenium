// Enable dragging for student cards
const draggables = document.querySelectorAll('.draggable');
const dropArea = document.getElementById('selected_students');

draggables.forEach(student => {
    student.addEventListener('dragstart', (e) => {
        e.dataTransfer.setData('text', student.id);
    });
});

dropArea.addEventListener('dragover', (e) => {
    e.preventDefault(); // Allow drop
});

dropArea.addEventListener('drop', (e) => {
    e.preventDefault();
    const id = e.dataTransfer.getData('text');
    const student = document.getElementById(id);
    dropArea.appendChild(student);
});
