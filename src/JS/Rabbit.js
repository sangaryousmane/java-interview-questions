class Rabbit {
    constructor(type, line) {
        this.type = type;
        this.line = line;
    }
    speak(){
        console.log(`The ${this.type} rabbit said ${this.line}`)
    }
    talkMap(){
        let talk=new Map();
        if (!talk.has(this.type))
            talk.set(this.type, this.line);
        console.log(talk)
    }
}

const blackRabbit = new Rabbit("EATER", "Hoo Hoo");
blackRabbit.speak();
blackRabbit.talkMap()