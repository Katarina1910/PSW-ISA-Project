export class Medicament{
    constructor(
        private name: string,
        private code: string,
        private description: string,
        private id: number
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