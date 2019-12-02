enum Type {examination, operation}
export class Room {   
    constructor(
        private  id: number,
        private  type: Type,
        private  isFree: boolean,
        private free: string,
        private  name: string,
    ){}

    public getIsFree():boolean{
        return this.isFree;
    }

    public setFree(s:string):void{
        this.free = s;
    }
}