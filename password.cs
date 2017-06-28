using System;

using System.Collections.Generic;

using System.Linq;

using System.Text;

using System.Threading.Tasks;

using Windows.Security.Credentials;

namespace PasswordVaultTest

{

class Program

18

{

static void Main(string[] args)

{

// Create a handle to the Widnows Password vault

Windows.Security.Credentials.PasswordVault vault = new PasswordVault();

// Retrieve all the credentials from the vault

IReadOnlyList<PasswordCredential> credentials = vault.RetrieveAll();

// The list returned is an IReadOnlyList, so there is no enumerator.

// No problem, we'll just see how many credentials there are and do it

the

// old fashioned way

for (int i = 0; i < credentials.Count; i++)

{

// Obtain the credential

PasswordCredential cred = credentials.ElementAt(i);

// "Fill in the password" (I wish I knew more about what this was

doing)

cred.RetrievePassword();

// Print the result

Console.WriteLine(cred.Resource + ':' + cred.UserName + ':' +

cred.Password);

}

Console.ReadKey();

}

}

}
