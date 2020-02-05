import { Doctor } from '../doctor/doctor';

export class DoctorTerm {   
    constructor(
        public id: number,
        public term1:boolean,
        public term2: boolean,
        public term3:boolean,
        public term4: boolean,
        public term5:boolean,
        public term6: boolean,
        public date: string,
        public doctorDTO: Doctor,
       
    ){}


   
}