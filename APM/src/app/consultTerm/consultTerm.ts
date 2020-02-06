import { User } from '../registration/user';
import { ConsultType } from '../consultType/consultType';
import { Doctor } from '../doctor/doctor';

export class ConsultTerm{
    constructor(
        public id:number,
        public date: Date,
        public  type: ConsultType,
        public  duration: number,
        public  price: number,
        public  discount: number,
        public room: string,
        public doctor: Doctor,
        public patient: User
    ){}
}