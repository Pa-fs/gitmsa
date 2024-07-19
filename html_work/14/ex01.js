console.log(document.getElementsByClassName("num")[0].getAttribute("value"));

function min() {
  alert("min 함수 호출");

  let mini = 1000000;

  for (let i = 0; i < 5; i++) {
    let val = Number(document.getElementsByClassName("num")[0].getAttribute("value"));

    if(mini > val) {
      mini = val;
    }

    console.log(val);
  }

  console.log(mini);
  document.getElementById("print_min").textContent = "최솟값 : " + mini;
}

function max() {
  alert("max 함수 호출");

  let n = document.getElementsByClassName("num");
  let maxi = -100000;

  for (let i = 0; i < n.length; i++) {
    let val = Number(n[i].getAttribute("value"));
  
    if(maxi < val) {
      maxi = val;
    }
  }
  console.log(maxi);

  document.getElementById("print_max").textContent = "최댓값 : " + maxi;
}

const btnMin = document.getElementById("btn-min");
btnMin.addEventListener("click", min);

const btnMax = document.getElementById("btn-max");
btnMax.addEventListener("click", max);
