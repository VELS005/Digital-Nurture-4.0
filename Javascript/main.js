// Exercise 1: JavaScript Basics & Setup
console.log("Welcome to the Community Portal");

window.addEventListener('load', function() {
    alert("Page is fully loaded");
});

// Exercise 2: Syntax, Data Types, and Operators
const eventName = "Music Night";
const eventDate = "2024-07-15";
let availableSeats = 50;

console.log(`Event: ${eventName} | Date: ${eventDate} | Seats: ${availableSeats}`);

// Simulate registration
availableSeats--;
console.log(`Seats after registration: ${availableSeats}`);

// Simulate cancellation
availableSeats++;
console.log(`Seats after cancellation: ${availableSeats}`);

// Exercise 3: Conditionals, Loops, and Error Handling
const events = [
    { name: "Music Night", date: "2024-07-15", seats: 10 },
    { name: "Art Fair", date: "2023-05-01", seats: 0 },
    { name: "Sports Day", date: "2024-08-10", seats: 5 }
];
const today = "2024-06-01";
console.log("Upcoming events with available seats:");
events.forEach(ev => {
    if (ev.date > today && ev.seats > 0) {
        console.log(`${ev.name} (${ev.date}) - Seats: ${ev.seats}`);
    }
});
function register(eventObj) {
    try {
        if (eventObj.seats <= 0) throw new Error("No seats available");
        eventObj.seats--;
        console.log(`Registered for ${eventObj.name}. Seats left: ${eventObj.seats}`);
    } catch (err) {
        console.error(err.message);
    }
}
register(events[0]);
register(events[1]);

// Exercise 4: Functions, Scope, Closures, Higher-Order Functions
function addEvent(arr, name, date, seats, category) {
    arr.push({ name, date, seats, category });
}
function registerUser(eventObj) {
    if (eventObj.seats > 0) eventObj.seats--;
}
function filterEventsByCategory(arr, cat) {
    return arr.filter(ev => ev.category === cat);
}
// Closure to track registrations per category
function categoryRegistrationCounter() {
    const counts = {};
    return function(category) {
        counts[category] = (counts[category] || 0) + 1;
        return counts[category];
    };
}
const countReg = categoryRegistrationCounter();
countReg("music"); countReg("music"); countReg("art");
// Higher-order filter
function filterEvents(arr, cb) {
    return arr.filter(cb);
}
filterEvents(events, ev => ev.seats > 0);

// Exercise 5: Objects and Prototypes
function Event(name, date, seats) {
    this.name = name;
    this.date = date;
    this.seats = seats;
}
Event.prototype.checkAvailability = function() {
    return this.seats > 0;
};
const evObj = new Event("Book Club", "2024-09-01", 12);
console.log(Object.entries(evObj));

// Exercise 6: Arrays and Methods
const allEvents = [
    { name: "Workshop on Baking", category: "workshop" },
    { name: "Music Night", category: "music" }
];
allEvents.push({ name: "Sports Day", category: "sports" });
const musicEvents = allEvents.filter(ev => ev.category === "music");
const eventCards = allEvents.map(ev => `Event: ${ev.name}`);

// Exercise 7: DOM Manipulation
// (Assumes HTML structure exists)
function renderEvents(arr) {
    const container = document.querySelector("#eventsList");
    if (!container) return;
    container.innerHTML = "";
    arr.forEach(ev => {
        const card = document.createElement("div");
        card.className = "event-card";
        card.textContent = `${ev.name} (${ev.category})`;
        container.appendChild(card);
    });
}
function updateSeatsUI(eventObj) {
    const el = document.querySelector(`#seats-${eventObj.name}`);
    if (el) el.textContent = eventObj.seats;
}

// Exercise 8: Event Handling
// (Assumes HTML structure exists)
function setupRegisterButtons() {
    document.querySelectorAll(".register-btn").forEach(btn => {
        btn.onclick = function() {
            const eventName = btn.dataset.event;
            const ev = allEvents.find(e => e.name === eventName);
            if (ev) registerUser(ev);
        };
    });
}
function setupCategoryFilter() {
    const sel = document.querySelector("#categoryFilter");
    if (sel) {
        sel.onchange = function() {
            const filtered = filterEventsByCategory(allEvents, sel.value);
            renderEvents(filtered);
        };
    }
}
function setupQuickSearch() {
    const input = document.querySelector("#searchInput");
    if (input) {
        input.onkeydown = function(e) {
            if (e.key === "Enter") {
                const val = input.value.toLowerCase();
                const filtered = allEvents.filter(ev => ev.name.toLowerCase().includes(val));
                renderEvents(filtered);
            }
        };
    }
}

// Exercise 9: Async JS, Promises, Async/Await
function fetchEventsMock() {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve([{ name: "Mock Event", date: "2024-10-01", seats: 20 }]);
        }, 1000);
    });
}
fetchEventsMock().then(data => console.log("Fetched events:", data)).catch(console.error);
async function fetchEventsAsync() {
    const spinner = document.querySelector("#loadingSpinner");
    if (spinner) spinner.style.display = "block";
    try {
        const data = await fetchEventsMock();
        console.log("Async/await events:", data);
    } finally {
        if (spinner) spinner.style.display = "none";
    }
}
fetchEventsAsync();

// Exercise 10: Modern JavaScript Features
function greet(name = "Guest") {
    return `Hello, ${name}!`;
}
const { name: evName, date: evDate } = events[0];
const eventsCopy = [...events];

// Exercise 11: Working with Forms
function handleFormSubmit(e) {
    e.preventDefault();
    const { name, email, eventType } = e.target.elements;
    if (!name.value || !email.value || !eventType.value) {
        showError("All fields required");
        return;
    }
    // ...submit logic...
}
function showError(msg) {
    let err = document.querySelector("#formError");
    if (!err) {
        err = document.createElement("div");
        err.id = "formError";
        err.style.color = "red";
        document.body.appendChild(err);
    }
    err.textContent = msg;
}

// Exercise 12: AJAX & Fetch API
function submitRegistration(data) {
    // Simulate POST to mock API
    setTimeout(() => {
        fetch("https://jsonplaceholder.typicode.com/posts", {
            method: "POST",
            body: JSON.stringify(data),
            headers: { "Content-Type": "application/json" }
        })
        .then(res => res.ok ? res.json() : Promise.reject("Failed"))
        .then(() => alert("Registration successful!"))
        .catch(() => alert("Registration failed!"));
    }, 1000);
}

// Exercise 13: Debugging and Testing
function debugRegistration(formData) {
    console.log("Submitting registration:", formData);
    // Add breakpoint here if debugging
    // Check fetch payload in Network tab
    submitRegistration(formData);
}

// Exercise 14: jQuery and JS Frameworks
// (Assumes jQuery is loaded)
if (window.$) {
    $('#registerBtn').click(function() {
        alert('Register button clicked!');
    });
    $('.event-card').fadeIn();
    $('.event-card').fadeOut();
    // Benefit: React/Vue provide component-based structure and reactive UI updates.
}
