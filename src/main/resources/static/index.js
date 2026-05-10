async function fetchanddisplaysubjects() {
    const container = document.getElementById("container");
    const subjects = await fetch("/api/getsubjects");
    const subjects_json = await subjects.json();
    const isadmin = await fetch("/api/isadmin");
    const isadmin_json = await isadmin.json();
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
    if (isadmin_json) {
        const add_subject = document.createElement("div");
        add_subject.className = "card";
        const add_subject_form = document.createElement("form");
        add_subject_form.action = "/api/addsubject";
        add_subject_form.method = "POST";
        const add_subject_name = document.createElement("input");
        add_subject_name.type = "text";
        add_subject_name.name = "name";
        add_subject_name.required = true;
        add_subject_name.placeholder = "enter subject name";
        const add_subject_imagepath = document.createElement("input");
        add_subject_imagepath.type = "text";
        add_subject_imagepath.name = "imagepath";
        add_subject_imagepath.required = true;
        add_subject_imagepath.placeholder = "enter imagepath";
        const add_subject_instructor = document.createElement("input");
        add_subject_instructor.type = "text";
        add_subject_instructor.name = "instructor";
        add_subject_imagepath.required = true;
        add_subject_instructor.placeholder = "enter instructor name"
        const add_subject_submit = document.createElement("button");
        add_subject_submit.type = "submit";
        add_subject_submit.textContent = "Add";
        container.appendChild(add_subject);
        add_subject.appendChild(add_subject_form);
        add_subject_form.appendChild(add_subject_name);
        add_subject_form.appendChild(add_subject_imagepath);
        add_subject_form.appendChild(add_subject_instructor);
        add_subject_form.appendChild(add_subject_submit);
    }
}
async function fetchanddisplaylectures() {
    const container = document.getElementById("container");
    const subject = new URLSearchParams(window.location.search).get("subject");
    const lectures = await fetch(`/api/lecturesbysubject?name=${subject}`);
    const lectures_json = await lectures.json();
    const isadmin = await fetch("/api/isadmin");
    const isadmin_json = await isadmin.json();
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
    if (isadmin_json) {
        const add_lecture = document.createElement("div");
        add_lecture.className = "card";
        const add_lecture_form = document.createElement("form");
        add_lecture_form.action = "/api/addlecture";
        add_lecture_form.method = "POST";
        const add_lecture_name = document.createElement("input");
        add_lecture_name.type = "text";
        add_lecture_name.name = "name";
        add_lecture_name.required = true;
        add_lecture_name.placeholder = "enter lecture name";
        const add_lecture_imagepath = document.createElement("input");
        add_lecture_imagepath.type = "text";
        add_lecture_imagepath.name = "imagepath";
        add_lecture_imagepath.required = true;
        add_lecture_imagepath.placeholder = "enter imagepath";
        const add_lecture_subject = document.createElement("input");
        add_lecture_subject.type = "text";
        add_lecture_subject.name = "subject";
        add_lecture_subject.required = true;
        add_lecture_subject.placeholder = "enter subject name"
        const add_lecture_url = document.createElement("input");
        add_lecture_url.type = "text";
        add_lecture_url.name = "url";
        add_lecture_url.required = true;
        add_lecture_url.placeholder = "enter drive url"
        const add_subject_submit = document.createElement("button");
        add_subject_submit.type = "submit";
        add_subject_submit.textContent = "Add";
        container.appendChild(add_lecture);
        add_lecture.appendChild(add_lecture_form);
        add_lecture_form.appendChild(add_lecture_name);
        add_lecture_form.appendChild(add_lecture_imagepath);
        add_lecture_form.appendChild(add_lecture_subject);
        add_lecture_form.appendChild(add_lecture_url);
        add_lecture_form.appendChild(add_subject_submit);

    }
}
async function fetchanddisplayprofile() {
    const container = document.getElementById("container");
    const profile = await fetch("/api/getprofile");
    const profile_json = await profile.json();
    container.innerHTML = "";
    const profile_name_container = document.createElement("div");
    profile_name_container.className = "card";
    const profile_name = document.createElement("h4");
    profile_name.textContent = "name:\t" + profile_json.name;
    const profile_username_container = document.createElement("div");
    profile_username_container.className = "card"
    const profile_username = document.createElement("h4");
    profile_username.textContent = "username:\t" + profile_json.username;
    const profile_gpa_container = document.createElement("div");
    profile_gpa_container.className = "card"
    const profile_gpa = document.createElement("h4");
    profile_gpa.textContent = "GPA:\t" + profile_json.gpa;
    const profile_birthyear_container = document.createElement("div");
    profile_birthyear_container.className = "card"
    const profile_birthyear = document.createElement("h4");
    profile_birthyear.textContent = "Birth year:\t" + profile_json.birthyear;
    const profile_email_container = document.createElement("div");
    profile_email_container.className = "card"
    const profile_email = document.createElement("h4");
    profile_email.textContent = "email:\t" + profile_json.email;
    container.appendChild(profile_email_container);
    container.appendChild(profile_name_container);
    container.appendChild(profile_username_container);
    container.appendChild(profile_birthyear_container);
    container.appendChild(profile_gpa_container);
    profile_email_container.appendChild(profile_email);
    profile_name_container.appendChild(profile_name);
    profile_username_container.appendChild(profile_username);
    profile_birthyear_container.appendChild(profile_birthyear);
    profile_gpa_container.appendChild(profile_gpa);
}
async function fetchanddisplayexams() {
    const container = document.getElementById("container");
    const subjects = await fetch("/api/getsubjects");
    const subjects_json = await subjects.json();
    container.innerHTML = "";
    subjects_json.forEach(subject => {
        const subject_link = document.createElement("a");
        subject_link.href = "?exam=" + subject.name;
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
async function fetchanddisplayexam() {
    const container = document.getElementById("container");
    const subject = new URLSearchParams(window.location.search).get("exam");
    const exams = await fetch(`/api/getexamsbysubject?name=${subject}`);
    const exams_json = await exams.json();
    console.log(exams_json);
    const isadmin = await fetch("/api/isadmin");
    const isadmin_json = await isadmin.json();
    container.innerHTML = "";
    exams_json.forEach(exam => {
        const exam_link = document.createElement("a");
        exam_link.href = exam.url;
        const exam_card = document.createElement("div");
        exam_card.className = "card";
        const exam_img = document.createElement("img");
        exam_img.src = exam.imagepath;
        const exam_text = document.createElement("h6");
        exam_text.textContent = exam.name;
        container.appendChild(exam_link);
        exam_link.appendChild(exam_card);
        exam_card.appendChild(exam_img);
        exam_card.appendChild(exam_text);
    });
    if (isadmin_json) {
        const add_exam = document.createElement("div");
        add_exam.className = "card";
        const add_exam_form = document.createElement("form");
        add_exam_form.action = "/api/addexam";
        add_exam_form.method = "POST";
        const add_exam_name = document.createElement("input");
        add_exam_name.type = "text";
        add_exam_name.name = "name";
        add_exam_name.required = true;
        add_exam_name.placeholder = "enter exam name";
        const add_exam_imagepath = document.createElement("input");
        add_exam_imagepath.type = "text";
        add_exam_imagepath.name = "imagepath";
        add_exam_imagepath.required = true;
        add_exam_imagepath.placeholder = "enter imagepath";
        const add_exam_subject = document.createElement("input");
        add_exam_subject.type = "text";
        add_exam_subject.name = "subject";
        add_exam_subject.required = true;
        add_exam_subject.placeholder = "enter subject name"
        const add_exam_url = document.createElement("input");
        add_exam_url.type = "text";
        add_exam_url.name = "url";
        add_exam_url.required = true;
        add_exam_url.placeholder = "enter drive url"
        const add_subject_submit = document.createElement("button");
        add_subject_submit.type = "submit";
        add_subject_submit.textContent = "Add";
        container.appendChild(add_exam);
        add_exam.appendChild(add_exam_form);
        add_exam_form.appendChild(add_exam_name);
        add_exam_form.appendChild(add_exam_imagepath);
        add_exam_form.appendChild(add_exam_subject);
        add_exam_form.appendChild(add_exam_url);
        add_exam_form.appendChild(add_subject_submit);

    }
}
async function fetchanddisplayannouncements() {
    const container = document.getElementById("container");
    const announcements = await fetch("/api/getannouncements");
    const announcements_json = await announcements.json();
    const isadmin = await fetch("/api/isadmin");
    const isadmin_json = await isadmin.json();
    container.innerHTML = "";
    announcements_json.forEach(announcement => {
        const announcement_card = document.createElement("div");
        announcement_card.className = "textcard";
        const announcement_title = document.createElement("h3");
        announcement_title.textContent = announcement.title
        const announcement_date = document.createElement("h6");
        announcement_date.textContent = announcement.time;
        const announcement_description = document.createElement("h5");
        announcement_description.textContent = announcement.description;
        container.appendChild(announcement_card);
        announcement_card.appendChild(announcement_title);
        announcement_card.appendChild(announcement_date);
        announcement_card.appendChild(announcement_description);
    });
    if (isadmin_json) {
        const add_announcement = document.createElement("div");
        add_announcement.className = "card";
        const add_announcement_form = document.createElement("form");
        add_announcement_form.action = "/api/addannouncement";
        add_announcement_form.method = "POST";
        const add_announcement_title = document.createElement("input");
        add_announcement_title.type = "text";
        add_announcement_title.name = "title";
        add_announcement_title.required = true;
        add_announcement_title.placeholder = "enter title";
        const add_announcement_description = document.createElement("input");
        add_announcement_description.type = "text";
        add_announcement_description.name = "description";
        add_announcement_description.required = true;
        add_announcement_description.placeholder = "content";
        const add_announcement_submit = document.createElement("button");
        add_announcement_submit.type = "submit";
        add_announcement_submit.textContent = "Add"
        container.appendChild(add_announcement);
        add_announcement.appendChild(add_announcement_form);
        add_announcement_form.appendChild(add_announcement_title);
        add_announcement_form.appendChild(add_announcement_description);
        add_announcement_form.appendChild(add_announcement_submit);
    }
}
const issubjects = new URLSearchParams(window.location.search).has('material');
const islectures = new URLSearchParams(window.location.search).has('subject');
const isprofile = new URLSearchParams(window.location.search).has('profile');
const isexams = new URLSearchParams(window.location.search).has('exams');
const isexam = new URLSearchParams(window.location.search).has('exam');
const isannouncments = new URLSearchParams(window.location.search).has('announcements');
if (issubjects) {
    fetchanddisplaysubjects();
}
else if (islectures) {
    fetchanddisplaylectures();
}
else if (isprofile) {
    fetchanddisplayprofile();
}
else if (isexams) {
    fetchanddisplayexams();
}
else if (isexam) {
    fetchanddisplayexam();
}
else if (isannouncments) {
    fetchanddisplayannouncements();
}