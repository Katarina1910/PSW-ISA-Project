import { User } from '../registration/user';
import { ConsultTerm } from '../consultTerm/consultTerm';
import { Medicament } from '../createMedicamentCodeBook/medicament';
import { listOfMedicaments } from '../listOfMedicaments/listOfMedicament';

export class Recipe{
    constructor(
        public id:number,
        public nurse: User,
        public doctor: User,
        public consultTerm: ConsultTerm,
        public isValidated: boolean,
        public medicaments: listOfMedicaments[]
    ){}
}