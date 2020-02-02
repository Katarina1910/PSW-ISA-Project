
export class MedicalRecordd{
    constructor(
       public id :number,
       public height :string,
       public weight :string,
       public bloodType :string,
       public diopter: string,
       public alergies: string,
       public disease: string
    ) {}

    public getId(){
        return this.id;
    }

    public getHeight(){
        return this.height;
    }

    public getWeight(){
        return this.weight;
    }

    public getBloodType(){
        return this.bloodType;
    }

    public getDiopter(){
        return this.diopter;
    }

    public getAlergies(){
        return this.alergies;
    }

    public getDisease(){
        return this.disease;
    }
}