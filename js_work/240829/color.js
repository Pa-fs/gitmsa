
let colors = ['orange', 'green', 'yellow'];

document.addEventListener("DOMContentLoaded", function() {
    let result = document.querySelector('#result');
    document.querySelector('#orange').onclick = () => {
        removeColor();
        result.classList.add('bg-orange-400');
    }

    document.querySelector('#green').onclick = () => {
        removeColor();
        result.classList.add('bg-green-400');
    }

    document.querySelector('#yellow').onclick = () => {
        removeColor();
        result.classList.add('bg-yellow-400');
    }
});

function removeColor() {
    for(let i = 0; i < colors.length; i++) {
        result.classList.remove(`bg-${colors[i]}-400`);
    }
}