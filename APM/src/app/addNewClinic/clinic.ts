export class Clinic{
    constructor(
        public name: string,
        public address: string,
        public description: string,
        public grade: number,
        public id: number,
        public income: number
    ){}

    public getId(){
        return this.id;
    }

    public getName(){
        return this.name;
    }

    public getAddress(){
        return this.address;
    }

    public getDescription(){
        return this.description;
    }

    public getGrade(){
        return this.grade;
    }
}