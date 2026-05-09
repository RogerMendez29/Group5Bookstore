let count = 0;
const display = document.getElementById('count');

function increment() {
  count++;
  display.textContent = count;
  display.classList.remove('bump');
  void display.offsetWidth;
  display.classList.add('bump');
}

document.getElementById('btn1').addEventListener('click', increment);
document.getElementById('btn2').addEventListener('click', increment);
document.getElementById('btn3').addEventListener('click', increment);

document.getElementById('resetBtn').addEventListener('click', () => {
  count = 0;
  display.textContent = 0;
});
