async function fetchanddisplaysubjects() {
    const container = document.getElementById("container");
    const subjects = await fetch("/api/getsubjects");
    const subjects_json = await subjects.json();
    container.innerHTML = "";
    subjects_json.forEach(subject => {
        const subject_link = document.createElement("a");
        subject_link.href = "?subject=" + subject.name;
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
async function fetchanddisplaylectures() {
    const container = document.getElementById("container");
    const lecture = new URLSearchParams(window.location.search).get("subject");
    const lectures = await fetch(`/api/lecturesbysubject?name=${lecture}`);
    const lectures_json = await lectures.json();
    container.innerHTML = "";
    lectures_json.forEach(lecture => {
        const lecture_link = document.createElement("a");
        lecture_link.href = lecture.url;
        const lecture_card = document.createElement("div");
        lecture_card.className = "card";
        const lecture_img = document.createElement("img");
        lecture_img.src = lecture.imagepath;
        const lecture_text = document.createElement("h6");
        lecture_text.textContent = lecture.name;
        container.appendChild(lecture_link);
        lecture_link.appendChild(lecture_card);
        lecture_card.appendChild(lecture_img);
        lecture_card.appendChild(lecture_text);
    });
}
const issubjects = new URLSearchParams(window.location.search).has('material');
if (issubjects) {
    console.log("subjectss");
    fetchanddisplaysubjects();
}
const islectures = new URLSearchParams(window.location.search).has('subject');
if (islectures) {
    console.log("lectures");
    fetchanddisplaylectures();
}