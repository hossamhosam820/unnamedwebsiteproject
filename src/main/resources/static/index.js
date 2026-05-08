async function fetchanddisplay() {
    const container = document.getElementById("container");
    const subjects = await fetch("/api/getsubjects");
    console.log(subjects);
    const subjects_json = await subjects.json();
    subjects_json.forEach(subject => {
        const subject_link = document.createElement("a");
        subject_link.href = "?" + subject.name;
        const subject_card = document.createElement("div");
        subject_card.className = "card";
        const subject_img = document.createElement("img");
        subject_img.src = subject.imagepath;
        const subject_text = document.createElement("h6");
        subject_text.textContent = subject.name;
        container.appendChild(subject_link);
        subject_link.appendChild(subject_card);
        subject_card.appendChild(subject_img);
        subject_card.appendChild(subject_text);
    });
}
fetchanddisplay();