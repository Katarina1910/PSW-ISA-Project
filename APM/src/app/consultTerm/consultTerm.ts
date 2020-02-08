import { User } from '../registration/user';
import { Recipe } from '../ConsultTermReport/Recipe';
import { listOfDiagnosis } from '../listOfAllDiagnosis/listOfAllDiagnosis';
import { ConsultType } from '../consultType/consultType';
import { Doctor } from '../doctor/doctor';
import { Room } from '../rooms/room';

export class ConsultTerm{
    constructor(
        public id:any,
        public report: string,
        public date: Date,
        public  type: ConsultType,
        public  duration: number,
        public  price: number,
        public  discount: number,
        public room: Room,
        public doctor: Doctor,
        public patient: User

    ){}
}