import { ConsultTerm } from '../consultTerm/consultTerm';
import { Nurse } from '../nurse/nurse';
import { Recipe } from './Recipe';
import { listOfDiagnosis } from '../listOfAllDiagnosis/listOfAllDiagnosis';

export class Consult {
    constructor(
        public id: string,
        public  consultTerm: ConsultTerm,
        public  recipe: Recipe,
        public  nurse: Nurse,
        public  diagnosis: listOfDiagnosis,
        public  report: string
    ){}
}