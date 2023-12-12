// let roseDragon = "Hello";
// for (let char of roseDragon) {
//     console.log(char.toUpperCase());
// }
const rabbit = {}
rabbit.speak = function (line) {
    console.log(`The ${this.type} rabbit said ${line}`);
}
let killerRabit = Object.create(rabbit);
killerRabit.type = "KILLER"
killerRabit.speak("DOUCH DOUCH")
//
// function speak(line) {
//     console.log(`The ${this.type} rabbit says '${line}'`);
// }
// let whiteRabbit = {type: "white", speak};
// let hungryRabbit = {type: "hungry", speak};
// hungryRabbit.speak("Oh my ears and whiskers, " +
//     "how late it's getting!");
//
// console.log(Object.getPrototypeOf(rabbit))
// console.log(Object.getPrototypeOf(Math.max) === Function.prototype);
// // rabbit.speak("I am a hero")

let object = new class {
    getWord() {
        return "hello";
    }
};
// console.log(object.getWord());

// Maps
let ages = new Map();
ages.set("Boris", 39)
ages.set("Júlia", 62)
ages.set("Liang",22)
console.log(ages.has("Boris"))