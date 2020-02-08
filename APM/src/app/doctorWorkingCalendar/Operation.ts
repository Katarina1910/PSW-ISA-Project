import { ReqForOp } from './ReqForOp';
import { Room } from '../rooms/room';

export class Operation {
    constructor(
        public id:number,
        public room: Room,
        public requestForOperation: ReqForOp
    ) {}
}