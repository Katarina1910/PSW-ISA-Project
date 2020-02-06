import { ConsultType } from 'src/consultType/consultType';
import { User } from '../registration/user';
import { Recipe } from '../ConsultTermReport/Recipe';
import { listOfDiagnosis } from '../listOfAllDiagnosis/listOfAllDiagnosis';

export class ConsultTerm{
    constructor(
        public id:any,
        public report: string,
        public date: Date,
        public  type: ConsultType,
        public  duration: number,
        public  price: number,
        public  discount: number,
        public room: string,
        public doctor: string,
        public patient: User,
        public diagnosis: listOfDiagnosis,
        public recipe: Recipe
    ){}
}