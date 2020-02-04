import { ConsultType } from 'src/consultType/consultType';
import { User } from '../registration/user';

export class ConsultTerm{
    constructor(
        public id:number,
        public date: Date,
        public  type: ConsultType,
        public  duration: number,
        public  price: number,
        public  discount: number,
        public room: string,
        public doctor: string,
        public patient: User
    ){}
}