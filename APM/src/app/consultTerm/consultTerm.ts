import { ConsultType } from 'src/consultType/consultType';
import { Time } from '@angular/common';
import { Room } from '../rooms/room';
import { User } from '../registration/user';

export class ConsultTerm {
    constructor(
        private id:number,
        private date: Date,
        private  type: ConsultType,
        private  duration: number,
        private  price: number,
        private  discount: number,
        private room: string,
        private doctor: string
    ){}
}