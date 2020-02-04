export class Clinic{
    constructor(
        private name: string,
        private address: string,
        private description: string,
        private grade: number,
        public id: number
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