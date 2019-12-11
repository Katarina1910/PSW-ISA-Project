export class Medicament{
    constructor(
        public name: string,
        public code: string,
        public description: string,
        public id: number
    ){}

    public getId(){
        return this.id;
    }

    public getName(){
        return this.name;
    }

    public getCode(){
        return this.code;
    }

    public getDescription(){
        return this.description;
    }

}