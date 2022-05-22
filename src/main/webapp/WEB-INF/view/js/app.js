const navBtn = document.getElementById("nav-btn");
const navbar = document.getElementById("navbar");
const navClose = document.getElementById("nav-close");

navBtn.addEventListener("click", () => {
    navbar.classList.add("showNav");
});
navClose.addEventListener("click", () => {
    navbar.classList.remove("showNav");
});

// Play Sound on click
const button = document.querySelector("#to_games_btn");

button.addEventListener("click", () => {
    playSound("sound/click.mp3");
});

function playSound(url) {
    var audio = document.createElement("audio");
    audio.style.display = "none";
    audio.src = url;
    audio.autoplay = true;
    audio.onended = function () {
        audio.remove(); //Remove when played.
    };
    document.body.appendChild(audio);
}
