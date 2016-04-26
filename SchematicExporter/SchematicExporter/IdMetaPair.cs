using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SchematicExporter
{
    struct IdMetaPair
    {
        int id;
        int meta;

		public IdMetaPair(int id, int meta)
        {
            this.id = id;
            this.meta = meta;
        }
    }
}
